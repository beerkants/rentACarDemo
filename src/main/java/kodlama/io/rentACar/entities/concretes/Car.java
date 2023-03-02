package kodlama.io.rentACar.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "plate",unique = true)
    private String plate;

    @Column(name = "name")
    private String name;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "state")
    private int state;


    @Column(name = "modelYear")
    private int modelYear;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
