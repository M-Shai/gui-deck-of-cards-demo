
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardDeck
{
	Image image;

	//private Image cardDeck[] = new Image[53];
	private HashMap<Double, Image> keyVal = new HashMap<>();
	private HashMap<Image, Double> valKey = new HashMap<>();


	public CardDeck()
	{
		final double SUITE = 0.5;
		final int CARDS = 14;
		int i =  0;

		System.out.println("ln 28: cardDeck size = " + keyVal.size());

		keyVal.put(0.0, (image = new Image("file:STARWARS\\card" + 52 + ".jpg")));
		valKey.put((image = new Image("file:STARWARS\\card" + 52 + ".jpg")), 0.0);

		for(double s = 0.1; s < SUITE; s += 0.1)
		{
			System.out.println("ln 36: (s) = " + s + " <<<i = " + i);
			for(int c = 1; c < CARDS; c++)
			{
				System.out.println("ln 39: (c) = " + c + " >>>i = " + i);
				keyVal.put(c + s, (image = new Image("file:STARWARS\\card" + i + ".jpg")));
				valKey.put((image = new Image("file:STARWARS\\card" + i + ".jpg")), c + s);

				i++;
			}
		}
		System.out.println("ln 45 cardDeck....outside loop........................\n" + keyVal);
	}

	public HashMap<Double, Image>  getSortDeck()
	{
		HashMap<Double, Image> deck = keyVal;
		//Image[] deck = cardDeck;
		return deck;
	}

	public HashMap<Double, Image> getShuffledDeck()
	{
		int i = 0;
		//int[] rndmIndex = new int[52];
		ArrayList<Integer> rndmIndex = new ArrayList<>();

		HashMap<Double, Image> rndmDeck = new HashMap<>();

		Set<Double> setKeys = keyVal.keySet();

		System.out.println("ln 68 " + setKeys.remove(0.0));

		Double[] aryKeys = setKeys.toArray(new Double[0]);

		Random rand = new Random();

		while(i < 52)
		{
			System.out.println("Inside CardDeck Line 71");
			int rdm = rand.nextInt(52);
			if(!rndmIndex.contains(rdm))
			{	System.out.println("Inside CardDeck Line 77");
				rndmIndex.add(rdm);
				i++;
			}
		}

		System.out.println(rndmIndex);
		for(int idx  = 0; idx < 1; idx++)
		{
			System.out.println("<<ln 83: idx = " + idx);
			for(i = 0; i < rndmIndex.size(); i++)
			{
				System.out.println(">>ln 86: i = " + i + "  aryKeys[rndmIndex.get(i)] = " +  aryKeys[rndmIndex.get(i)]);
				Double k = aryKeys[rndmIndex.get(i)];
				//Double k = 1.1;
				Image v= keyVal.get(k);
				System.out.println(">>>>ln 89: v = " + v + " :k = " + k);
				/*
				for(Entry<Double, Image> entry: cardDeck.entrySet())
				{
					System.out.println(">>>>ln 88<<<<");
					if(entry.getValue() == v)
					{
						System.out.println(">>>>+++ln 91+++<<<<");
						k = entry.getKey();
					}
				}*/
				//System.out.println("ln 95 <<< :k = " + k);
				rndmDeck.put(k, v);
				System.out.println("ln 102");
			}
			System.out.println("ln 104: rndmDeck = \n" + rndmDeck);
			System.out.println("--------------ln 99----------------------");
		}
		System.out.println("ln 111 cardDeck(0.0) = " + keyVal.get(0.0));
		rndmDeck.put(0.0, (image = new Image("file:STARWARS\\card" + 52 + ".jpg")));

		return rndmDeck;

	}


}