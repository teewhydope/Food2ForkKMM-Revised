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
                LazyVStack(alignment: .leading) {
                    ForEach(viewModel.state(\.recipeList) as [RecipePresentationModel], id: \.self) { recipe in
                        HStack{
                            AsyncImage(url: URL(string: recipe.featuredImage)) { image in
                                image.resizable()
                            } placeholder: {
                                Color.white
                            }
                            .frame(width: 128, height: 128)
                            .clipShape(RoundedRectangle(cornerRadius: 25))
                            VStack(alignment: .leading){
                                Text(recipe.title)
                                Text("Publisher: \(recipe.publisher)")
                            }
                        }.padding([.leading, .trailing], 16)
                    }
                }.background(Color.purple)
            }
        }
    }
}
    
    struct ContentView_Previews: PreviewProvider {
        static var previews: some View {
            ContentView()
        }
    }
