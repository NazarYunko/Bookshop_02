package com.bookshop.dto;

import com.bookshop.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
public class DtoUtilMapper {

    public static AuthorDto getNotFullAuthorDto(Author author) {
        return new AuthorDto(author.getId(), author.getName(), author.getLastName(), author.getPathImage());
    }

    public static AuthorDto getFullAuthorDto(Author author) {
        return new AuthorDto(author.getId(), author.getName(), author.getLastName(), author.getDateOfBirth(), author.getBiography(), author.getPathImage());
    }

    public static List<AuthorDto> getNotFullAuthorsDto(List<Author> authors) {
        List<AuthorDto> authorsDto = new ArrayList<>();
        for (Author currentAuthor : authors) {
            authorsDto.add(getNotFullAuthorDto(currentAuthor));
        }
        return authorsDto;
    }

    public static BookDto getNotFullBookDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getPathImage());
    }

    public static BookDto getFullBookDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getGenre(), book.getDescription(), book.getCountOfPages(), book.getAuthor(), book.getDateOfPublication(), book.getPublisher(), book.getPrice(), book.getQuantity(), book.getPathImage());
    }

    public static List<BookDto> getNotFullBooksDto(List<Book> books) {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book currentBook : books) {
            booksDto.add(getNotFullBookDto(currentBook));
        }
        return booksDto;
    }

    public static CityDto getCityDto(City city) {
        return new CityDto(city.getId(), city.getName(), city.getCountry());
    }

    public static List<CityDto> getCitiesDto(List<City> cities) {
        List<CityDto> citiesDto = new ArrayList<>();
        for (City currentCity : cities) {
            citiesDto.add(getCityDto(currentCity));
        }
        return citiesDto;
    }

    public static CountryDto getCountryDto(Country country) {
        return new CountryDto(country.getId(), country.getName());
    }

    public static List<CountryDto> getCountriesDto(List<Country> countries) {
        List<CountryDto> countriesDto = new ArrayList<>();
        for (Country currentCountry : countries) {
            countriesDto.add(getCountryDto(currentCountry));
        }
        return countriesDto;
    }

    public static GenreDto getGenreDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

    public static List<GenreDto> getGenresDto(List<Genre> genres) {
        List<GenreDto> genresDto = new ArrayList<>();
        for (Genre currentGenre : genres) {
            genresDto.add(getGenreDto(currentGenre));
        }
        return genresDto;
    }

    public static OrdersDto getOrderDto(Orders orders) {
        return new OrdersDto(orders.getId(), orders.getSum(), orders.getOrdersBooks());
    }

    public static List<OrdersDto> getOrdersDto(List<Orders> orders) {
        List<OrdersDto> ordersDto = new ArrayList<>();
        for (Orders currentOrder : orders) {
            ordersDto.add(getOrderDto(currentOrder));
        }
        return ordersDto;
    }

    public static PublisherDto getPublisherDto(Publisher publisher) {
        return new PublisherDto(publisher.getId(), publisher.getName(), publisher.getPathImage());
    }

    public List<PublisherDto> getPublisherDto(List<Publisher> publishers) {
        List<PublisherDto> publishersDto = new ArrayList<>();
        for (Publisher currentPublisher : publishers) {
            publishersDto.add(getPublisherDto(currentPublisher));
        }
        return publishersDto;
    }

    public static UserDto getUserDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getEmail(), user.getName(), user.getLastName());
    }

    public static List<UserDto> getUsersDto(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User currentUser : users) {
            usersDto.add(getUserDto(currentUser));
        }
        return usersDto;
    }


}