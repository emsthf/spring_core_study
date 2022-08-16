package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)  // 이 옵션은 컴포넌트 스캔으로 스프링 빈을 등록할 때 스캔에서 제외할 것을 설정하는 것
)
public class AutoAppConfig {

}
