package org.factoriaf5.rna_transcription;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DNAtoRNA_BuilderTest {

    private DNAtoRNA_Builder transcript;
    @BeforeEach
    public void setUp() {
        transcript = new DNAtoRNA_Builder();
    }

    @Test
    void testGetDnaSeq() {
        transcript.setDnaSeq("ATGC");
        transcript.getDnaSeq();
        assertEquals("ATGC", transcript.getDnaSeq());
    }

    @Test
    void testTranscribe() {
        transcript.setDnaSeq("AGCT");
        transcript.transcribe();
        assertEquals("UCGA", transcript.transcribe());
    }

    @Test
    void testValidateDNANegative() {
        transcript.setDnaSeq("AXCT");
        assertThrows(IllegalArgumentException.class, () -> transcript.transcribe());
    }
}
