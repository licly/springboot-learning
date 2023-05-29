package org.charlie.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Charlie-6327
 * @date 2023/5/1
 */
@Data
@Accessors(chain = true)
public class User {

    private Long id;

    @NotNull
    @Size(min = 5, max = 10)
    private String name;

    private String address;
}
