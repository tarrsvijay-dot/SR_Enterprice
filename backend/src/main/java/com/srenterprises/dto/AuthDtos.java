package com.srenterprises.dto; import jakarta.validation.constraints.*;
public final class AuthDtos { private AuthDtos(){} public record Register(@NotBlank String name,@Email String email,@Size(min=8,max=100) String password,String phone){} public record Login(@Email String email,@NotBlank String password){} public record Token(String token,String role,String name){} }
