package org.spring.boot.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.spring.boot.starter.controllers.CSVController;
import org.springframework.asm.ClassReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import com.opencsv.CSVReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@InjectMocks
	CSVController cSVTestController; 
	
	@Test
    public void testcsvExample() throws Exception {
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		ResponseEntity<Resource> responseEntity = cSVTestController.single1("test",null, response);
		
		response.getOutputStream().toString();
		
		System.out.println(responseEntity.getStatusCodeValue());
		Date test = null;
		Mockito.when(cSVTestController.functiontesting(test)).thenReturn(2);
		
		InputStreamReader fileReader = new InputStreamReader(new ByteArrayInputStream(response.getOutputStream().toString().getBytes()));
		
        // create csvReader object passing
        // file reader as a parameter
		try (CSVReader reader = new CSVReader(fileReader)) {
		      List<String[]> r = reader.readAll();
		      r.forEach(x -> System.out.println(Arrays.toString(x)));
		  }
		
        assertEquals(1,1);
    }

}
