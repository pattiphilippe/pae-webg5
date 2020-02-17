package patti.philippe.recap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentFilter{
    private String number;
    private String name;
    private String section;
    private Integer bloc;
}