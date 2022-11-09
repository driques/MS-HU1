package com.mingeso.uploadService.controllers;

import com.mingeso.uploadService.services.ReceiptsService;
import com.mingeso.uploadService.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/receipts/files")
@CrossOrigin( "http://localhost:3000" )
public class UploadController {
    @Autowired
    UploadService uploadService;
    @Autowired
    ReceiptsService receiptsService;

    @PostMapping("/receipts/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {

            System.out.println("Nombre de archivo: " + file.getOriginalFilename());
            // Subir archivo
            uploadService.save(file);
            // A partir de archivo guardado, leer este y guardar datos en bd
            //receiptsService.(file.getOriginalFilename());

            return ResponseEntity.ok().body("Archivo subido correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not upload the file: " + file.getOriginalFilename() + "!");
        }
    }

}

