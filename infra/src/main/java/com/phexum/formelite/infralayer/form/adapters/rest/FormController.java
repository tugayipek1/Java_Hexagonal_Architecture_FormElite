package com.phexum.formelite.infralayer.form.adapters.rest;

import com.phexum.formHandler.domain.form.model.FormGetResponseDto;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.usecase.*;
import com.phexum.formelite.infralayer.common.BaseController;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/form")
public class FormController extends BaseController {

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FormCreateUseCase usecase) {
        return ResponseEntity.ok(handle(FormModel.class, usecase));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody FormUpdateUseCase usecase) {
        return ResponseEntity.ok(handle(FormModel.class, usecase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(handle(FormModel.class, new FormGetByIdUseCase(id)));
    }

    @GetMapping("/{formId}/submit")
    public ResponseEntity<?> findFormAndFormSubmitById(@PathVariable("formId") Long id) {
        return ResponseEntity.ok(handle(List.class, new GetFormSubmitValueByFormUseCase(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        handle(new FormDeleteByIdUseCase(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> formSubmit(@PathVariable Long id, @RequestBody Map<String, String> payload, HttpServletRequest request ) {
        handle(new FormSubmitUseCase(id,payload,request.getRemoteAddr(),request.getHeader("OperatingSystem")));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list-by-account")
    public ResponseEntity<?> listByAccount(@RequestBody FormGetAllByAccountUsecase usecase) {
        return ResponseEntity.ok(handle(List.class, usecase));
    }

}
