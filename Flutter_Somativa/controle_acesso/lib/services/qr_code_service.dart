import 'package:qr_code_scanner/qr_code_scanner.dart';
import 'package:flutter/material.dart';

class QRCodeService {
  final GlobalKey qrKey = GlobalKey(debugLabel: 'QR');

  void onQRViewCreated(QRViewController controller) {
    controller.scannedDataStream.listen((scanData) {
      // Ação após escaneamento bem-sucedido
      // Pode chamar FirebaseService para salvar dados no Firestore
    });
  }
}
