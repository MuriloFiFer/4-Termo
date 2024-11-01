import 'package:geolocator/geolocator.dart';

class LocationService {
  Future<bool> isWithinAllowedArea(double lat, double lon) async {
    Position position = await Geolocator.getCurrentPosition();
    double distance = Geolocator.distanceBetween(
      lat, lon, position.latitude, position.longitude,
    );
    return distance < 100; // Exemplo de distância permitida em metros
  }
}
