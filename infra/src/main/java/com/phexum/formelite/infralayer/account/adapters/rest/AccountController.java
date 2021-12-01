package com.phexum.formelite.infralayer.account.adapters.rest;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.usecase.*;
import com.phexum.formelite.infralayer.common.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController extends BaseController {


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        handle(new AccountDeleteByIdUseCase(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(handle(List.class, new AccountGetAllUseCase()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        return ResponseEntity.ok(handle(AccountModel.class, new AccountGetByIdUseCase(id)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountRegisterationUseCase usecase) {

        return ResponseEntity.ok(handle(AccountModel.class, usecase));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AccountUpdateUseCase usecase) {

        return ResponseEntity.ok(handle(AccountModel.class, usecase));

    }


}
