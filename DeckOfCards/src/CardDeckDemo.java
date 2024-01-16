import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class CardDeckDemo extends Application
{

	private ImageView cardView;
	private Image cvr;
	private CardDeck deck;
	private HashMap<Double, Image> cardDeck;
	ArrayList<Integer> rndmIndex = new ArrayList<>();

	private int i;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		deck = new CardDeck();

		cardDeck = deck.getSortDeck();

		//System.out.println("ln 42....cardDeck = " + cardDeck.get(0.0));
		cvr = cardDeck.get(0.0);
		cardView = new ImageView(cvr);


		Set<Double> setKeys = cardDeck.keySet();

		//System.out.println("ln 68 " + setKeys.remove(0.0));
		setKeys.remove(0.0);

		Double[] aryKeys = setKeys.toArray(new Double[0]);

		Random rand = new Random();

		i = 0;

		while(i < 52)
		{
			//System.out.println("Inside CardDeck Line 71");
			int rdm = rand.nextInt(52);
			if(!rndmIndex.contains(rdm))
			{
				//System.out.println("Inside CardDeck Line 77");
				rndmIndex.add(rdm);
				i++;
			}
		}
		//System.out.println("ln 66-------------\n " + rndmIndex);

		//System.out.println("ln 63....cardDeck = " + cardDeck.get(0.0));
		//cardView = new ImageView(cardDeck.get(0.0));

		i = 0;
		//Register events
		cardView.setOnMousePressed(event ->
		{


			if(i < 52)
			{
				//System.out.println(">>ln 86: i = " + i + "  aryKeys[rndmIndex.get(i)] = " +  aryKeys[rndmIndex.get(i)]);
				Double k = aryKeys[rndmIndex.get(i)];

				Image v = cardDeck.get(k);
				//System.out.println(">>>>ln 89: v = " + v + " :k = " + k);

				cardView.setImage(v);
				//System.out.println("ln 102");
				i++;
			}

			else
			{
				//System.out.println("ln 99 cvr = " + cvr);
				cardView.setImage(cvr);
				i = 0;
				rndmIndex.clear();
				while(i < 52)
				{
					//System.out.println("Inside CardDeck Line 105");
					int rdm = rand.nextInt(52);
					if(!rndmIndex.contains(rdm))
					{
						//System.out.println("Inside CardDeck Line 109");
						rndmIndex.add(rdm);
						i++;
					}
				}
				//System.out.println("ln 114==============\n " + rndmIndex);
				//cardView = new ImageView(cvr);
				i = 0;
			}

		});

		//add image view to a Pane
		Pane pane = new Pane(cardView);

		//create a scene
		Scene scene = new Scene (pane);

		//add scene to the stage
		primaryStage.setScene(scene);

		//show the window
		primaryStage.show();
	}


}