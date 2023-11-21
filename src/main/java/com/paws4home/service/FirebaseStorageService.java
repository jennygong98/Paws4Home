package com.paws4home.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "paws4home-a2482.appspot.com";

    //Esta es la ruta básica de este proyecto Paws4home
    final String rutaSuperiorStorage = "paws4home";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "paws4home-a2482-firebase-adminsdk-bd9xt-51b03523ff.json";
}
