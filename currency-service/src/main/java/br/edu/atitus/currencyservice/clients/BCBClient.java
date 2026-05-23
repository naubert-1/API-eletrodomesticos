package br.edu.atitus.currencyservice.clients;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bcb-client", url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata", fallback = BCBClientFallback.class)
public interface BCBClient {
    @GetMapping("/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?@moeda='{MOEDA}'&@dataCotacao='05-20-2026'&$format=json")
    @Retry(name = "bcb-client")
    BCBResponse getBCBCurrency(@PathVariable ("MOEDA") String moeda);
}