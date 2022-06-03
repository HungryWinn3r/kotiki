package app.controller;

import app.entity.OwnerEntity;
import app.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity saveOwner(@RequestBody OwnerEntity owner) {
        ownerService.saveOwner(owner);
        return ResponseEntity.ok().body(ownerService.convert(ownerService.findByPassportOwner(owner.getPassportCode())));
    }

    @DeleteMapping
    public ResponseEntity deleteOwner(@RequestParam int passportCode) {
        ownerService.deleteOwner(passportCode);
        return ResponseEntity.ok().body("Удалил)");
    }

    @GetMapping
    public ResponseEntity findByPassportOwner(@RequestParam int passport) {
        if (ownerService.findByPassportOwner(passport) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ownerService.convert(ownerService.findByPassportOwner(passport)));
    }

    @GetMapping("/all")
    public ResponseEntity getOwners() {
        return ResponseEntity.ok().body(ownerService.convert(ownerService.getAllOwners()));
    }
}