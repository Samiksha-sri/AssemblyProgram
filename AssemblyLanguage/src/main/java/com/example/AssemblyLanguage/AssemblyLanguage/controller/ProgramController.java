package com.example.AssemblyLanguage.AssemblyLanguage.controller;

import com.example.AssemblyLanguage.AssemblyLanguage.dtos.RequestDTO;
import com.example.AssemblyLanguage.AssemblyLanguage.dtos.ResponseDTO;
import com.example.AssemblyLanguage.AssemblyLanguage.entities.Program;
import com.example.AssemblyLanguage.AssemblyLanguage.entities.StatusCode;
import com.example.AssemblyLanguage.AssemblyLanguage.service.ProgramService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService){
        this.programService = programService;
    }

    @PostMapping("/assemble")
    public ResponseDTO assembleProgram(@RequestBody RequestDTO requestDTO){

        ResponseDTO responseDTO = new ResponseDTO();

        Program program = new Program();

        program.setStatements(requestDTO.getStatements());

        try{

          int result =  programService.executeProgram(requestDTO.getStatements());
          program.setStatusCode(StatusCode.valueOf("SUCCESS"));
          program.setResult(result);
          programService.saveRecord(program);
           responseDTO.setStatusCode(StatusCode.valueOf("SUCCESS"));
           responseDTO.setMessage("Registers added successfully");
           responseDTO.setResult(result);
            return responseDTO;
        }
        catch (Exception e){
            responseDTO.setStatusCode(StatusCode.valueOf("FAILURE"));
            responseDTO.setMessage("Assemble program failed");
            return responseDTO;
        }

    }


}
