import com.tinkerforge.IPConnection;
import com.tinkerforge.BrickletSoundIntensity;

public class ExampleSimple {
	private static final String HOST = "localhost";
	private static final int PORT = 4223;

	// Change XYZ to the UID of your Sound Intensity Bricklet
	private static final String UID = "XYZ";

	// Note: To make the example code cleaner we do not handle exceptions. Exceptions
	//       you might normally want to catch are described in the documentation
	public static void main(String args[]) throws Exception {
		IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletSoundIntensity si = new BrickletSoundIntensity(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		// Get current intensity
		int intensity = si.getIntensity(); // Can throw com.tinkerforge.TimeoutException
		System.out.println("Intensity: " + intensity);

		System.out.println("Press key to exit"); System.in.read();
		ipcon.disconnect();
	}
}
