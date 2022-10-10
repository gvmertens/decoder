package br.com.mertens.ead.authuser.clients;

import br.com.mertens.ead.authuser.dtos.CourseDto;
import br.com.mertens.ead.authuser.dtos.ResponsePageDto;
import br.com.mertens.ead.authuser.services.UtilsService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j2
@Component
public class CourseClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UtilsService utilsService;

    @Value("${ead.api.url.course}")
    String REQUEST_URL_COURSE;

    @CircuitBreaker(name = "circuitbreakerInstance")
    public Page<CourseDto> getAllCoursesByUser(UUID userId, Pageable pageable){
        List<CourseDto> searchResult = null;
        String url = REQUEST_URL_COURSE + utilsService.createUrlGetAllCoursesByUser(userId, pageable);
        log.info("URL: {} ", url);
        try{
            ParameterizedTypeReference<ResponsePageDto<CourseDto>> responseType = new ParameterizedTypeReference<ResponsePageDto<CourseDto>>() {};
            ResponseEntity<ResponsePageDto<CourseDto>> result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            searchResult = result.getBody().getContent();
            log.debug("Response Number of Elements: {} ", searchResult.size());
        } catch (HttpStatusCodeException e){
            log.error("Error request /courses {} ", e);
        }
        log.info("Ending request /courses userId {} ", userId);
        return new PageImpl<>(searchResult);
    }

    public Page<CourseDto> circuitbreakerfallback(UUID userId, Pageable pageable, Throwable t) {
        log.error("Circuit breaker fallback, cause - {}", t.toString());
        List<CourseDto> searchResult = new ArrayList<>();
        return new PageImpl<>(searchResult);
    }

    public Page<CourseDto> retryfallback(UUID userId, Pageable pageable, Throwable t) {
        log.error("Retry retryfallback, cause - {}", t.toString());
        List<CourseDto> searchResult = new ArrayList<>();
        return new PageImpl<>(searchResult);
    }
}
