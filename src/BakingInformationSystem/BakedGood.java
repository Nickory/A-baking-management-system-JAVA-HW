package BakingInformationSystem;
import DataStructure.List;
import java.util.Comparator;

public class BakedGood {
    private String name;
    private String origin;
    private String description;
    private String imageUrl;

    @Override
    public String toString() {
        return "BakedGood{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public BakedGood(String name, String origin, String description, String imageUrl) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static void sortBakedGoodsByName(List<BakedGood> bakedGoods) {
        bakedGoods.quickSort(new Comparator<BakedGood>() {
            @Override
            public int compare(BakedGood o1, BakedGood o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortBakedGoodsByOrigin(List<BakedGood> bakedGoods) {
        bakedGoods.quickSort(new Comparator<BakedGood>() {
            @Override
            public int compare(BakedGood o1, BakedGood o2) {
                return o1.getOrigin().compareTo(o2.getOrigin());
            }
        });
    }

    public static void sortBakedGoodsByDescription(List<BakedGood> bakedGoods) {
        bakedGoods.quickSort(new Comparator<BakedGood>() {
            @Override
            public int compare(BakedGood o1, BakedGood o2) {
                return o1.getDescription().compareTo(o2.getDescription());
            }
        });
    }
}
