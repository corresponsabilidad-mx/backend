package mx.org.corresponsabilidadsocial.api.blog.repositories;


import java.util.*;

import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import mx.org.corresponsabilidadsocial.api.blog.services.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.entities.Status;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.NotFound;

@Repository
public class PostRepository {

    @Autowired
    private FirebaseInitializer firebaseInitializer;

    public List<Post> getPosts() throws ExecutionException, InterruptedException {
        List<Post> posts = new ArrayList<>();
        Post post = null;

        Iterable<DocumentReference> documentsReference = getCollection().listDocuments();
        Iterator<DocumentReference> iterator = documentsReference.iterator();

        while (iterator.hasNext()){
            DocumentReference documentReference = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot documentSnapshot = future.get();

            post = documentSnapshot.toObject(Post.class);
            posts.add(post);
        }
        return posts;
    }

    public String addPost(Post post) throws Exception {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", post.getId());
        docData.put("title", post.getTitle());
        docData.put("imageUrl", post.getImageUrl());
        docData.put("text", post.getText());
        docData.put("date", Timestamp.now());
        docData.put("status", post.getStatus());

        CollectionReference posts = getCollection();
        ApiFuture<WriteResult> writeResultApiFuture = posts.document().create(docData);
        if (!writeResultApiFuture.get().equals(null)){
            return writeResultApiFuture.get().getUpdateTime().toString();
        }
        throw new Exception();
    }

    public Post getPostById(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = getCollection().document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Post post = null;
        if (document.exists()){
            post = document.toObject(Post.class);
            return post;
        }
        return null;
    }
/*
    public boolean deletePostById(Integer id) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(id)) {
                posts.remove(i);
                return true;
            }
        }
        return false;
    }

    public Post updatePostById(Integer id, Post post) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(id)) {
                posts.get(i).setTitle(post.getTitle());
                posts.get(i).setText(post.getText());
                posts.get(i).setImageUrl(post.getImageUrl());
                posts.get(i).setStatus(post.getStatus());
                posts.get(i).setDate(LocalDate.now());
                return posts.get(i);
            }
        }
        throw new NotFound(id);
    }

     */

    private CollectionReference getCollection() {
        return firebaseInitializer.getFirestore().collection("posts");
    }
}
