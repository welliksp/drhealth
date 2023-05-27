package br.com.wsp.drhealth.controller.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/doctor")
@Tag(name = "Doctor", description = "Endpoints for Managing Doctor")
public class DoctorController {


}
