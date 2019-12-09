package lambda;


import lombok.Data;

@Data
public class Apple {

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("color", color)
                .append("weight", weight)
                .toString();
    }
}
