package com.Zidio.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.DTO.ApplicationDTO;
import com.Zidio.DTO.EmailRequest;
import com.Zidio.DTO.UpdateApplicationStatusDTO;
import com.Zidio.Entity.Application;
import com.Zidio.Enum.ApplicationStatus;
import com.Zidio.Repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private EmailService emailService;

    public ApplicationDTO applyJob(ApplicationDTO dto) {
        // Prevent duplicate applications
        if (applicationRepository.existsByJobIdAndEmployeeEmail(dto.jobId, dto.employeeEmail)) {
            throw new RuntimeException("You have already applied for this job.");
        }

        Application app = new Application();
        app.setJobId(dto.jobId);
        app.setEmployeeEmail(dto.employeeEmail);
        app.setRecruiterEmail(dto.recruiterEmail);
        app.setStatus(ApplicationStatus.APPLIED);
        app.setResumeURL(dto.resumeURL);

        applicationRepository.save(app);

        // Send email on apply
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo(dto.employeeEmail);
        emailRequest.setSubject("Application Submitted");
        emailRequest.setBody("You have successfully applied for job ID: " + dto.jobId);
        emailService.sendEmail(emailRequest);

        return mapToDTO(app);
    }

    public List<ApplicationDTO> getByEmployeeEmail(String employeeEmail) {
        return applicationRepository.findByEmployeeEmail(employeeEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByRecruiterEmail(String recruiterEmail) {
        return applicationRepository.findByRecruiterEmail(recruiterEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ApplicationDTO updateApplicationStatus(UpdateApplicationStatusDTO dto) {
        Optional<Application> optional = applicationRepository.findById(dto.getApplicatiionId());

        if (!optional.isPresent()) {
            throw new RuntimeException("Application not found");
        }

        Application app = optional.get();

        try {
            ApplicationStatus newStatus = ApplicationStatus.valueOf(dto.getStatus().toString());
            app.setStatus(newStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + dto.status);
        }

        applicationRepository.save(app);

        // Send email on status update
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo(app.getEmployeeEmail());
        emailRequest.setSubject("Application Status Updated");
        emailRequest.setBody("Your application status for job ID " + app.getJobId() + " is now: " + app.getStatus());
        emailService.sendEmail(emailRequest);

        return mapToDTO(app);
    }

    public void deleteApplication(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new RuntimeException("Application not found with ID: " + id);
        }
        applicationRepository.deleteById(id);
    }

    public List<ApplicationDTO> getByStatus(ApplicationStatus status) {
        return applicationRepository.findByStatus(status)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ApplicationDTO mapToDTO(Application app) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(app.getId());
        dto.setJobId(app.getJobId());
        dto.setEmployeeEmail(app.getEmployeeEmail());
        dto.setRecruiterEmail(app.getRecruiterEmail());
        dto.setStatus(app.getStatus());
        dto.setResumeURL(app.getResumeURL());
        return dto;
    }
}
