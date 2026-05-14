package re.edu.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PageDto<T>{

    private int size;
    private int page;
    private int totalPages;
    private long totalElements;
    private List<T> data;
}
