package com.example.ikandra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ikandra.Service.PdfService;

@RestController
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    private PdfService pdfService;
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> getPdf() {
        byte[] pdfContent = pdfService.generatePdf();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Facture.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }
}

