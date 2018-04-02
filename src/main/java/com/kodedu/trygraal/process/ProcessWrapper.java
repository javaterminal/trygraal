package com.kodedu.trygraal.process;

import com.pty4j.PtyProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ProcessWrapper {

    private final PtyProcess process;
    private BufferedWriter outputWriter;
    private BufferedReader inputReader;
    private BufferedReader errorReader;

    public ProcessWrapper(PtyProcess process) {
        this.process = process;
    }

    public BufferedWriter getOutputWriter() {
        return outputWriter;
    }

    public void setOutputWriter(BufferedWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public BufferedReader getInputReader() {
        return inputReader;
    }

    public void setInputReader(BufferedReader inputReader) {
        this.inputReader = inputReader;
    }

    public BufferedReader getErrorReader() {
        return errorReader;
    }

    public void setErrorReader(BufferedReader errorReader) {
        this.errorReader = errorReader;
    }

    public PtyProcess getProcess() {
        return process;
    }
}
