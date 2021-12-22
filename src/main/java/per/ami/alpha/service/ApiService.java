package per.ami.alpha.service;

import per.ami.alpha.pojo.dto.Gif;
import per.ami.alpha.pojo.dto.InfoPage;

public interface ApiService {
    InfoPage getPage(String currency);
    String getStringPage(String currency);
}
