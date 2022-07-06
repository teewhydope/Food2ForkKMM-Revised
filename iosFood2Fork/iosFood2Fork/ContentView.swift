import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI

struct ContentView: View {
    @StateObject var viewModel: RecipeListViewModel = RecipeListViewModel()
    
    var body: some View {
        if viewModel.state(\.isLoading) {
            ProgressView()
        } else {
            ScrollView {
                LazyVStack {
                    ForEach(viewModel.state(\.recipeList) as [RecipePresentationModel], id: \.self) { recipe in
                        Text(recipe.title)
                    }
                }
            }
        }
    }
}
    
    struct ContentView_Previews: PreviewProvider {
        static var previews: some View {
            ContentView()
        }
    }
