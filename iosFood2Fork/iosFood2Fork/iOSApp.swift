import SwiftUI
import MultiPlatformLibrary

@main
struct iOSApp: App {
    init() {
          BridgeKt.doInit { (clazz) -> PopkornMapping in
              return clazz.alloc() as! PopkornMapping
          }
      }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
