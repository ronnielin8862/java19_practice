package org.example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TEST")
public class AddStaffBo {

    @Schema(description = "name")
    private String name;

    @Schema(description = "gender")
    private String gender;

    @Schema(description = "生日")
    private String birthday;
}
