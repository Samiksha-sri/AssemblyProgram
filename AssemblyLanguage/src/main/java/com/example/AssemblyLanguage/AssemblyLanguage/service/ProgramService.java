package com.example.AssemblyLanguage.AssemblyLanguage.service;

import com.example.AssemblyLanguage.AssemblyLanguage.dtos.ResponseDTO;
import com.example.AssemblyLanguage.AssemblyLanguage.entities.Program;
import com.example.AssemblyLanguage.AssemblyLanguage.entities.StatusCode;
import com.example.AssemblyLanguage.AssemblyLanguage.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    private ResponseDTO responseDTO;

    @Autowired
    public ProgramService(ProgramRepository programRepository){
        this.programRepository = programRepository;
    }

    public int executeProgram(String statements){
        int reg1 = 0;
        int reg2 = 0;

        String [] instructions = statements.split("\n");

        for(String instruction : instructions){
            String [] parts = instruction.split(" ");
            String instructionType = parts[0];
            String values = parts[1];

            if(instructionType.equals("MV")){

                int value = Integer.parseInt(values.substring((values.lastIndexOf("#") + 1)));

                if(values.startsWith("REG1")){
                    reg1 = value;
                }
                else if(values.startsWith("REG2")){
                    reg2 = value;
                }
            }
            else if(instructionType.equals("ADD")){
                if(values.startsWith("REG1")){
                   String subValue = values.substring(values.lastIndexOf(",") + 1);

                   if(subValue.equals("REG2")){
                       reg1 = reg1 + reg2;
                   }
                   else{
                       int constant = Integer.parseInt(subValue.substring((subValue.lastIndexOf(",") + 1)));
                       reg1 = reg1 + constant;
                   }


                }

            }
            else if(instructionType.equals("SHOW")){

                return reg1;

            }
        }
        return 0;
    }

    public Program saveRecord(Program program){
        Program newRecord =programRepository.save(program);
        return newRecord;
    }

}
