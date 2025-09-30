package com.Zidio.Security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

import com.Zidio.Entity.PaidSubscription;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoiceGenerator {

    public static ByteArrayInputStream generateInvoice(PaidSubscription sub) {
        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(doc, out);
            doc.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLDITALIC);
            Font labelFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            Font valueFont = new Font(Font.FontFamily.HELVETICA, 11);

            Paragraph title = new Paragraph("Subscription Invoice", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(2);
            table.setWidths(new float[]{3, 7});
            table.setWidthPercentage(80);
            table.setSpacingBefore(20);

            table.addCell(new Paragraph("Subscription ID", labelFont));
            table.addCell(new Paragraph(String.valueOf(sub.getId()), valueFont));

            table.addCell(new Paragraph("Recruiter ID", labelFont));
            table.addCell(new Paragraph(String.valueOf(sub.getRecruiterId()), valueFont));

            table.addCell(new Paragraph("Employee ID", labelFont));
            table.addCell(new Paragraph(String.valueOf(sub.getEmployeeId()), valueFont));

            table.addCell(new Paragraph("Plan ID", labelFont));
            table.addCell(new Paragraph(String.valueOf(sub.getPlanId()), valueFont));

            table.addCell(new Paragraph("Amount", labelFont));
            table.addCell(new Paragraph(String.valueOf(sub.getAmount()), valueFont));

            table.addCell(new Paragraph("Currency", labelFont));
            table.addCell(new Paragraph(sub.getCurrency(), valueFont));

            table.addCell(new Paragraph("Payment Status", labelFont));
            table.addCell(new Paragraph(sub.getPaymentStatus().toString(), valueFont));

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            table.addCell(new Paragraph("Start Date", labelFont));
            table.addCell(new Paragraph(sub.getStartDate().format(fmt), valueFont));

            table.addCell(new Paragraph("End Date", labelFont));
            table.addCell(new Paragraph(sub.getEndDate().format(fmt), valueFont));

            doc.add(table);

            Paragraph footer = new Paragraph("Thank you for subscribing to Zidio!", new Font(Font.FontFamily.HELVETICA, 10));
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(30);
            doc.add(footer);

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
