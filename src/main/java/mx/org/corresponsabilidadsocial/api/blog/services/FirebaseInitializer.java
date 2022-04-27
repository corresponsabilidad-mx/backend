package mx.org.corresponsabilidadsocial.api.blog.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Objects;

@Service
public class FirebaseInitializer {

    @PostConstruct
    private void initDB() throws IOException {

        ClassLoader classLoader = FirebaseInitializer.class.getClassLoader();
        File file = new File(
                Objects.requireNonNull(classLoader.getResource("blog-csm-firebase-adminsdk.json")).getFile());
        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://csm-blog-86d4d.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
    }

    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}
