package wia2007.example.healthier_app;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser {

    private DatabaseReference databaseReference;

    public DAOUser() {
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = db.getReference(User.class.getSimpleName());
    }

    public Task<Void> add(User us) {
        return databaseReference.push().setValue(us);
    }

    public Task<Void> addWithId(User us, String id) {
        return databaseReference.child(id).setValue(us);
    }
}
