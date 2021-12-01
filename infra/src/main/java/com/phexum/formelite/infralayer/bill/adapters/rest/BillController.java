package com.phexum.formelite.infralayer.bill.adapters.rest;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.usecase.*;
import com.phexum.formelite.infralayer.common.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bill")
@RestController
public class BillController extends BaseController {

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BillUpdateUseCase usecase) {
        System.out.println("usecase");
        return ResponseEntity.ok(handle(BillModel.class, usecase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        handle(new BillDeleteByIdUseCase(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(handle(List.class, new BillGetAllUseCase()));
    }

    @GetMapping("/list-by-account")
    public ResponseEntity<?> getByAccount(@RequestBody BillGetByAccountUseCase usecase) {
        return ResponseEntity.ok(handle(List.class, usecase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(handle(BillModel.class, new BillGetByIdUseCase(id)));
    }

}
