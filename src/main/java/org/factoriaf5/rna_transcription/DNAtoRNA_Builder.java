package org.factoriaf5.rna_transcription;

public class DNAtoRNA_Builder {

    private String dnaSeq;

    public DNAtoRNA_Builder(String dnaSeq) {
        if (dnaSeq == null || dnaSeq.isEmpty()) {
            throw new IllegalArgumentException("Secuencia de ADN inválida.");
        }
        this.dnaSeq = dnaSeq;
    }
    public DNAtoRNA_Builder() {
    }

    public void setDnaSeq(String dnaSeq) {
        this.dnaSeq = dnaSeq;
    }
    public String getDnaSeq() {
        return dnaSeq;
    }

    public boolean validateDNA() {
        return dnaSeq.matches("[ATGC]+"); // Solo permite A, T, G y C (el + es para que al menos haya un caracter en la sequencia)
    }

    public String transcribe() {
        if (!validateDNA()) {
            throw new IllegalArgumentException("Secuencia de ADN inválida.");
        }

        StringBuilder rnaSeq = new StringBuilder();

        for (char nucleotide : dnaSeq.toCharArray()) {  // for-each no funciona sobre strings
            switch (nucleotide) {
                case 'G': rnaSeq.append('C'); break;
                case 'C': rnaSeq.append('G'); break;
                case 'T': rnaSeq.append('A'); break;
                case 'A': rnaSeq.append('U'); break;
                default: throw new IllegalArgumentException("Nucleótido inválido: " + nucleotide);
            }
        }
        return rnaSeq.toString();
    }
}