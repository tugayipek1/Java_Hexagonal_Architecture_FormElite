package com.phexum.formelite.infralayer.journal.adapters.rest;

import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.usecase.*;
import com.phexum.formelite.infralayer.common.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/journal")
@RestController
public class JournalController extends BaseController {


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        handle(new JournalDeleteByIdUseCase(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(handle(List.class, new JournalGetAllUseCase()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        return ResponseEntity.ok(handle(JournalModel.class, new JournalGetByIdUseCase(id)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody JournalUpdateUseCase usecase) {

        return ResponseEntity.ok(handle(JournalModel.class, usecase));
    }

}
