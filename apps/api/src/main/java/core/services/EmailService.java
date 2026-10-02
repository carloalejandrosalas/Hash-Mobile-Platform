package core.services;


import config.Bootstrap;
import core.dtos.SmtpCredentials;
import io.javalin.http.BadGatewayResponse;
import jakarta.mail.Message;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.recipient.RecipientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    private static Mailer mailer = null;
    private static final SmtpCredentials smtpCredentials = Bootstrap.getSmtpCreds();

    public static void sendEmail(String to, String subject, String body) {
        try {
            if (mailer == null) {
                mailer = constructMailer();
            }

            Email email = EmailBuilder.startingBlank()
                    .from("Hash Mobile", smtpCredentials.from())
                    .withRecipients(new RecipientBuilder()
                            .withAddress(to)
                            .withType(Message.RecipientType.TO)
                            .build()
                    )
                    .withSubject(subject)
                    .withHTMLText(body)
                    .buildEmail();


            mailer.sendMail(email);

        } catch (Exception e) {
            IO.println(e);
            log.error("Failed to send email to {}: {}", to, e.getMessage());
            throw new BadGatewayResponse("The email sending failed ");
        }
    }

    public static Mailer constructMailer () {
        return MailerBuilder
                .withSMTPServer(
                        smtpCredentials.host(),
                        smtpCredentials.port(),
                        smtpCredentials.username(),
                        smtpCredentials.password())
                .withTransportStrategy(
                        smtpCredentials.isSecure() ? TransportStrategy.SMTP_TLS : TransportStrategy.SMTP
                )
                .buildMailer();
    }
}
