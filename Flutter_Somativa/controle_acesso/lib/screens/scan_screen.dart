import 'package:flutter/material.dart';
import 'package:qr_code_scanner/qr_code_scanner.dart';
import '../services/firebase_service.dart';
import '../services/qr_code_service.dart';

class ScanScreen extends StatefulWidget {
  @override
  _ScanScreenState createState() => _ScanScreenState();
}

class _ScanScreenState extends State<ScanScreen> {
  final qrService = QRCodeService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Escanear QR Code')),
      body: Center(
        child: QRView(
          key: qrService.qrKey,
          onQRViewCreated: qrService.onQRViewCreated,
        ),
      ),
    );
  }
}
