package com.zhaosha.springBootDemo;

import com.zhaosha.springBootDemo.cacheDemo.dao.BookRepository;
import com.zhaosha.springBootDemo.mongodbDemo.bean.Customer;
import com.zhaosha.springBootDemo.mongodbDemo.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableCaching//开启缓存
@EnableScheduling//开启调度任务
@EnableAsync//开启异步任务
public class SpringBootDemoApplication extends AsyncConfigurerSupport implements CommandLineRunner {

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private BookRepository bookRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootDemoApplication.class, args);

        /**
         * redis消息队列测试
         */
        ApplicationContext ctx = SpringApplication.run(SpringBootApplication.class, args);
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        template.convertAndSend("chat", "hello from redis");
        latch.await();
        System.exit(0);
    }

    /**
     * 查看springboot启动注入了哪些bean
     *
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Override
    public void run(String... strings) throws Exception {
        customerRepository.deleteAll();

        //save info
        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Smith"));

        //fetch all customers
        System.out.println("Customers found with findall():");
        System.out.println("----------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerRepository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : customerRepository.findByLastName("Smith")) {
            System.out.println(customer);
        }


        System.out.println("*****************************");
        System.out.println(".... Fetching books");
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
    }


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }
}
