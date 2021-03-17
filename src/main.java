import java.util.ArrayList;

public class main
{
    public static void main(String[] args)
    {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Orange> OB1 = new Box<>(orange, orange, orange, apple);
        Box<Orange> OB2 = new Box<>(orange);
        Box<Apple> AB1 = new Box<>(apple, apple, apple, apple);
        Box<Apple> AB2 = new Box<>(apple, apple);
        OB1.info("OB1");
        OB2.add(orange,orange,apple, apple,orange);
        OB2.info("OB2");
        AB1.info("AB1");
        AB2.info("AB2");
        AB1.moveTo(AB2);
        OB1.moveTo(AB2);
        OB1.info("OB1");
        AB1.info("AB1");
        AB2.info("AB2");
        System.out.println(OB1.compare(OB2));
        OB1.add(orange);
        System.out.println(OB1.compare(OB2));
        System.out.println(AB1.compare(OB2));


    }
    public static class Apple extends Fruit
    {
        public Apple()
        {
            super("Apple", 1.0f);
        }

    }
    public static class Orange extends Fruit
    {
        public Orange()
        {
            super("Orange", 1.5f);
        }
    }
    public static class Box<T extends Fruit>
    {
        private ArrayList<Fruit> fruitList = new ArrayList<>();
        private float fruitWeight;
        private final String fruitType;

        public Box(T fruitType, Fruit... fruits)
        {
            this.fruitType = fruitType.getName();
            for(Fruit fruit: fruits)
            {
                if(fruit.getName().equals(this.fruitType))
                {
                    add((T) fruit);
                }
            }
        }

        public String getFruitType() {
            return fruitType;
        }
        public void info(String boxName)
        {
            System.out.println("Box " + boxName + " " + this.fruitType + " " + this.getFruitWeight());

        }
        public float getFruitWeight()
        {
            return fruitWeight;
        }
        public boolean compare (Box otherBox)
        {
            return this.getFruitWeight() == otherBox.getFruitWeight();
        }
        public void add(Fruit... fruits)
        {
            for(Fruit fruit: fruits)
            {
                if(fruit.getName().equals(fruitType))
                {
                    fruitList.add(fruit);
                    fruitWeight += fruit.getWeight();
                }
            }

        }
        public void moveTo(Box otherBox)
        {
            if(otherBox.getFruitType().equals(fruitType))
            {
                for(Fruit fruit: fruitList)
                {
                    otherBox.add(fruit);
                }
            fruitWeight = 0;
            fruitList.clear();
            }
        }

    }
    public static class Fruit
    {
        private final String name;
        private final float weight;

        public Fruit(String name, float weight)
        {
            this.name = name;
            this.weight = weight;
        }

        public float getWeight()
        {
            return weight;
        }

        public String getName() {
            return name;
        }
    }
}

