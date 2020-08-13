package ru.kdv.parserBigData.parser;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;
import ru.kdv.parserBigData.model.ValidationRows;
import ru.kdv.parserBigData.model.json.*;
import ru.kdv.parserBigData.util.XlsValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static ru.kdv.parserBigData.constant.XlsTransferConstant.*;
import static ru.kdv.parserBigData.writer.Writer.createXlsFileFromErrorRows;

public class Parser {

    public static void parseFiles() {
        String resourceDirectory = "src/main/resources/";
        readRegistryFile(new File(resourceDirectory + "CA_TRANSFER_HI_10.06.2020.xlsx"));
    }

    private static void readRegistryFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = StreamingReader.builder()
                     .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                     .bufferSize(1024)     // buffer size to use when reading InputStream to file (defaults to 1024)
                     .open(fileInputStream)) {


            parseFirstSheet(workbook.getSheetAt(0));
            //parseSecondSheet(workbook.getSheetAt(1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseFirstSheet(Sheet sheet) {
        ValidationRows validationRows = new ValidationRows();
        int clientCounter = 0;
        List<Client> clientList = new ArrayList<>();

        for (Row row : sheet) {

            if (isHeaderRow(row)) {
                continue;
            }

            List<Integer> incorrectColumnNumbers = XlsValidator.validateRow(row);

            if (incorrectColumnNumbers.size() != 0) {
                rejectNotValidRows(row, incorrectColumnNumbers, validationRows);
                continue;
            }

            parseClients(row, clientList);

            clientCounter++;


        }

        createXlsFileFromErrorRows(validationRows.getErrorRows(), validationRows.getNotValidCells(), validationRows.getAndIncrementCounter());
    }

    private static void parseClients(Row row, List<Client> clientList) {
        System.out.print((int) row.getCell(CA_ID).getNumericCellValue() + " ");
        System.out.print(row.getCell(TB).getStringCellValue() + " ");
        System.out.print(row.getCell(CLIENT_ID).getStringCellValue() + " ");
        System.out.print(row.getCell(CONTRACT_ID).getStringCellValue() + " ");
        System.out.print(row.getCell(CONTRACT_NUMBER).getStringCellValue() + " ");
        System.out.print(row.getCell(CONTRACT_ISSUE_DATE).getDateCellValue() + " ");
        System.out.print(row.getCell(CONTRACT_END_DATE).getDateCellValue() + " ");
        System.out.print(row.getCell(CREDIT_TYPE).getStringCellValue() + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(CREDIT_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(row.getCell(BORROWER_TYPE).getStringCellValue() + " ");
        System.out.print(row.getCell(FIO).getStringCellValue() + " ");
        System.out.print(row.getCell(DOB).getDateCellValue() + " ");
        System.out.print(row.getCell(REGISTRATION_ADDRESS).getStringCellValue() + " ");
        System.out.print(row.getCell(ACTUAL_ADDRESS).getStringCellValue() + " ");
        System.out.print(row.getCell(REGISTRY_PHONE_NUMBER).getStringCellValue() + " ");
        System.out.print(row.getCell(ACTUAL_PHONE_NUMBER).getStringCellValue() + " ");
        System.out.print(row.getCell(MOBILE_PHONE).getStringCellValue() + " ");
        System.out.print(row.getCell(OTHER_PHONE).getStringCellValue() + " ");
        System.out.print(row.getCell(RECOVERY_STAGE).getStringCellValue() + " ");
        System.out.print(row.getCell(INCLUSION_DATE).getDateCellValue() + " ");
        System.out.print(row.getCell(EXPIRATION_DATE).getDateCellValue() + " ");
        System.out.print(row.getCell(MATURITY_START_DATE).getDateCellValue() + " ");
        System.out.print(row.getCell(MATURITY_END_DATE).getDateCellValue() + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(URGENT_DEBT_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(OVERDUE_DEBT).getNumericCellValue())) + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(TERM_INTEREST_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(OVERDUE_INTEREST_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(FINES_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(STATE_DUTY).getNumericCellValue())) + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(OVERDUE_DEBT_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(row.getCell(DELAY_FORMATION_DATE).getDateCellValue() + " ");
        System.out.print((int) row.getCell(DELAY_NUMBERS_DAYS).getNumericCellValue() + " ");
        System.out.print(row.getCell(LAST_PAYMENT_DATE).getDateCellValue() + " ");
        System.out.print(new BigDecimal(String.valueOf(row.getCell(LAST_PAYMENT_AMOUNT).getNumericCellValue())) + " ");
        System.out.print(row.getCell(TARGET_VOLUME).getNumericCellValue() + " ");
        System.out.print(row.getCell(INTEREST_RATE).getNumericCellValue() + " ");
        System.out.print((int) row.getCell(INN).getNumericCellValue() + " ");

        System.out.println();

        Client.builder()
                .inclusionDebtDate(parseDataField(row.getCell(INCLUSION_DATE)))
                .completionDate(parseDataField(row.getCell(EXPIRATION_DATE)))
                .interestRate(parsePercentField(row.getCell(INTEREST_RATE)))
                .clientInfo(ClientInfo.builder()
                        .id(parseStringField(row.getCell(CLIENT_ID)))
                        .territorialBank(parseStringField(row.getCell(TB)))
                        .FIO(parseStringField(row.getCell(FIO)))
                        .DOB(parseStringField(row.getCell(DOB)))
                        .INN(parseIntField(row.getCell(INN)))
                        .address(Address.builder()
                                .actualAddress(parseStringField(row.getCell(ACTUAL_ADDRESS)))
                                .registrationAddress(parseStringField(row.getCell(REGISTRATION_ADDRESS)))
                                .build())
                        .phoneNumbers(addPhoneNumbers(row))
                        .build())
                .contractInfo(ContractInfo.builder()
                        .id(parseStringField(row.getCell(CONTRACT_ID)))
                        .number(parseStringField(row.getCell(CONTRACT_ID)))
                        .issueDate(parseDataField(row.getCell(CONTRACT_ISSUE_DATE)))
                        .expirationDate(parseDataField(row.getCell(CONTRACT_END_DATE)))
                        .type(parseStringField(row.getCell(CREDIT_TYPE)))
                        .member(parseStringField(row.getCell(BORROWER_TYPE)))
                        .stage(parseStringField(row.getCell(RECOVERY_STAGE)))
                        .maturityStartDate(parseDataField(row.getCell(MATURITY_START_DATE)))
                        .maturityEndDate(parseDataField(row.getCell(MATURITY_END_DATE)))
                        .amount(Amount.builder()
                                //todo
                                .build())
                        .delayDate(parseDataField(row.getCell(DELAY_FORMATION_DATE)))
                        .countDaysPast(DELAY_NUMBERS_DAYS)
                        .lastPayment(LastPayment.builder()
                                //todo
                                .build())

                        .build())
                .build();
    }

    private static List<PhoneNumber> addPhoneNumbers(Row row) {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        Cell mobilePhone = row.getCell(MOBILE_PHONE);
        Cell registrationPhone = row.getCell(REGISTRY_PHONE_NUMBER);
        Cell actualPhone = row.getCell(ACTUAL_PHONE_NUMBER);
        Cell otherPhone = row.getCell(OTHER_PHONE);
        if (mobilePhone != null && !mobilePhone.getStringCellValue().trim().isEmpty()) {
            phoneNumbers.add(PhoneNumber.builder()
                    .number(parseStringField(mobilePhone))
                    .type("Mobil")
                    .build());
        }
        if (registrationPhone != null && !registrationPhone.getStringCellValue().trim().isEmpty()) {
            phoneNumbers.add(PhoneNumber.builder()
                    .number(parseStringField(registrationPhone))
                    .type("RegistrationAddress")
                    .build());
        }
        if (actualPhone != null && !actualPhone.getStringCellValue().trim().isEmpty()) {
            phoneNumbers.add(PhoneNumber.builder()
                    .number(parseStringField(actualPhone))
                    .type("ActualAddress")
                    .build());
        }
        if (otherPhone != null && !otherPhone.getStringCellValue().trim().isEmpty()) {
            phoneNumbers.add(PhoneNumber.builder()
                    .number(parseStringField(otherPhone))
                    .type("Other")
                    .build());
        }
        return phoneNumbers;
    }

    private static Integer parseIntField(Cell cell) {
        String value = cell.getStringCellValue();
        if (cell == null || value.trim().isEmpty()) {
            return null;
        }
        return Integer.valueOf(value);
    }

    private static String parseStringField(Cell cell) {
        if (cell == null) {
            return null;
        }
        return cell.getStringCellValue();
    }

    private static BigDecimal parsePercentField(Cell cell) {
        if (cell == null) {
            return null;
        }
        String value = String.valueOf(cell.getNumericCellValue());
        BigDecimal bigDecimal = new BigDecimal(value);
        BigDecimal multiply = new BigDecimal(100);
        return bigDecimal.multiply(multiply).setScale(2, RoundingMode.CEILING);
    }


    private static String parseDataField(Cell cell) {
        if (cell == null) {
            return null;
        }
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(cell.getDateCellValue());
    }

    private static boolean isHeaderRow(Row row) {
        if (row.getCell(0) == null) {
            return false;
        }
        return row.getCell(0).getCellType() != CellType.NUMERIC;
    }

    private static void rejectNotValidRows(Row row, List<Integer> incorrectColumnNumbers, ValidationRows validationRows) {
        validationRows.getErrorRows().add(row);
        validationRows.getNotValidCells().add(incorrectColumnNumbers);

        boolean isNeedToRefresh = validationRows.getErrorRows().size() >= 10_000;
        if (isNeedToRefresh) {
            writeNotValidRowsInFile(validationRows);
        }
    }

    private static void writeNotValidRowsInFile(ValidationRows validationRows) {
        createXlsFileFromErrorRows(validationRows.getErrorRows(), validationRows.getNotValidCells(), validationRows.getAndIncrementCounter());
        validationRows.refresh();
    }

    private static void parseSecondSheet(Sheet sheetAt) {
    }

}
