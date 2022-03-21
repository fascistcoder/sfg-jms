package com.example.sfgjms.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/03/22
 */
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {

    static final long serialVersionUID = 2148048805838793986L;

    private UUID id;
    private String message;
}
