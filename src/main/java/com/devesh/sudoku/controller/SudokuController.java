package com.devesh.sudoku.controller;

import com.devesh.sudoku.model.Cell;
import com.devesh.sudoku.model.StartMessage;
import com.devesh.sudoku.service.SudokuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping
@Log4j2
public class SudokuController {

    private final SudokuService sudokuService;

    @PostMapping(value = "/start")
    public ResponseEntity<String> startSudoku(@RequestBody StartMessage startMessage) throws Exception {
        log.info("Message is: {}" , startMessage.getMessage());
        if(startMessage.getMessage().equals("START")) {
            sudokuService.restartGame();
            log.info("New sudoku is generated");
            return new ResponseEntity<>("READY", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid Start message", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/move/row/col")
    public ResponseEntity<String> moveInsertion(@RequestBody Cell cell) {

        String message = sudokuService.moveInsertion(cell);
        log.info("The move is: {}", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/move")
    public ResponseEntity<String> moveInsertion2(@RequestBody Cell cell) {
        String message = sudokuService.moveInsertion(cell);
        log.info("The move is: {}", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
