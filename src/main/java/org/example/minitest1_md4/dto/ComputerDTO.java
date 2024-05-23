package org.example.minitest1_md4.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.minitest1_md4.model.TypeComputer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDTO {
    private Long id;
    @Pattern(regexp = "^CG.{6}$", message = " Code bắt đầu bằng chữ CG và có 8 ký tự")
    private String computerCode;
    @NotBlank(message = "khong de trong truong nay")
    private String computerName;
    @NotBlank(message = "khong trong truong nay")
    private String producer;
    private TypeComputer typeComputer;
}
