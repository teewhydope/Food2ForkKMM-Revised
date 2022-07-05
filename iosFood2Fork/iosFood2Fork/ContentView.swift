import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI

struct ContentView: View {
    @ObservedObject var viewModel = RecipeListViewModel()
    
    var textString: String {
        return viewModel.textValue.value as! String
       }
    
	var body: some View {
        Text(textString)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
