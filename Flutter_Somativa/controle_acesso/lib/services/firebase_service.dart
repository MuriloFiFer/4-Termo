import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';

class FirebaseService {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  Future<void> saveVisitorData(String name, String documentNumber) async {
    final user = _auth.currentUser;
    if (user != null) {
      await _firestore.collection('visitors').add({
        'name': name,
        'documentNumber': documentNumber,
        'checkInTime': DateTime.now(),
        'userId': user.uid,
      });
    }
  }
}
