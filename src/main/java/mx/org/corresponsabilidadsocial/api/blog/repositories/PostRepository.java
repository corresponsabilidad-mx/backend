package mx.org.corresponsabilidadsocial.api.blog.repositories;

import java.util.*;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import mx.org.corresponsabilidadsocial.api.blog.services.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;

@Repository
public class PostRepository {

    @Autowired
    private FirebaseInitializer firebaseInitializer;

    @Autowired
    FileRepository fileRepository;

    public List<Post> getPosts() throws Exception {

        List<Post> posts = new ArrayList<>();
        Iterable<DocumentReference> documentsReference = getCollection().listDocuments();
        Iterator<DocumentReference> iterator = documentsReference.iterator();

        while (iterator.hasNext()) {
            posts.add(iterator.next().get().get().toObject(Post.class));
        }
        return posts;
    }

    public String addPost(Post post) throws Exception {
        Map<String, Object> docData = new HashMap<>();
        docData.put("title", post.getTitle());
        docData.put("imageUrl", post.getImageUrl());
        docData.put("text", post.getText());
        docData.put("date", Timestamp.now().toDate());
        docData.put("status", post.getStatus());

        ApiFuture<DocumentReference> addedDocRef = getCollection().add(docData);
       

        return "A post was created with id: " + addedDocRef.get().getId();
    }

    public Post getPostById(String id) throws Exception {
        ApiFuture<DocumentSnapshot> futureResult= getCollection().document(id).get();
        return futureResult.get().toObject(Post.class);
    }

    public String deletePostById(String id) {
        ApiFuture<WriteResult> writeResult = getCollection().document(id).delete();

        return "Succesfully deleted, post id: " + writeResult.toString();
    }

    public String updatePostById(String id, Post post) throws Exception {

        DocumentReference documentReference = getCollection().document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Map<String, Object> docData = document.getData();

        docData.put("title", post.getTitle());
        docData.put("imageUrl", post.getImageUrl());
        docData.put("text", post.getText());
        docData.put("date", Timestamp.now().toDate());
        docData.put("status", post.getStatus());

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).update(docData);

        return "Succesfully updated, post id: " + id + "datetime: " + writeResultApiFuture.get().getUpdateTime();
    }

    private CollectionReference getCollection() {
        return firebaseInitializer.getFirestore().collection("posts");
    }
}
