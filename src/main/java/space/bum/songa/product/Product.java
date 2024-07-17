package space.bum.songa.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    // DB에서.. 이게 식별자인데..?
    // 이곳은 자바 코드! hibernate(Entitymanager,... JPA 구현체)
    // EntityContext 안에서 identifier(식별자 = DB의 PK)를 가지고 Entity를 구별
    @Id
    private int id;
    private String name;
    private int price;
    private String description;
}
