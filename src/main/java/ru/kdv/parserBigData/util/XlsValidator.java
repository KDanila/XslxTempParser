package ru.kdv.parserBigData.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;

import static ru.kdv.parserBigData.constant.XlsTransferConstant.*;
import static ru.kdv.parserBigData.constant.XlsValidatorConstant.VALID_VALUE;

public class XlsValidator {
    public static List<Integer> validateRow(Row row) {
        List<Integer> errorFields = new ArrayList<>();
        errorFields.add(checkCaIdField(row.getCell(CA_ID)));
        errorFields.add(checkTbField(row.getCell(TB)));
        errorFields.add(checkClientIdField(row.getCell(CLIENT_ID)));
        errorFields.add(checkContractIdField(row.getCell(CONTRACT_ID)));
        errorFields.add(checkContractNumberField(row.getCell(CONTRACT_NUMBER)));
        errorFields.add(checkContractIssueDateField(row.getCell(CONTRACT_ISSUE_DATE)));
        errorFields.add(checkContractEndDateField(row.getCell(CONTRACT_END_DATE)));
        errorFields.add(checkCreditTypeField(row.getCell(CREDIT_TYPE)));
        errorFields.add(checkCreditAmountField(row.getCell(CREDIT_AMOUNT)));
        errorFields.add(checkBorrowerTypeField(row.getCell(BORROWER_TYPE)));
        errorFields.add(checkFioField(row.getCell(FIO)));
        errorFields.add(checkDobField(row.getCell(DOB)));
        errorFields.add(checkRegistrationAddressField(row.getCell(REGISTRATION_ADDRESS)));
        errorFields.add(checkActualAddressField(row.getCell(ACTUAL_ADDRESS)));
        errorFields.add(checkRegistryPhoneNumberField(row.getCell(REGISTRY_PHONE_NUMBER)));
        errorFields.add(checkActualPhoneNumberField(row.getCell(ACTUAL_PHONE_NUMBER)));
        errorFields.add(checkMobilePhoneField(row.getCell(MOBILE_PHONE)));
        errorFields.add(checkOtherPhoneField(row.getCell(OTHER_PHONE)));
        errorFields.add(checkRecoveryStageField(row.getCell(RECOVERY_STAGE)));
        errorFields.add(checkInclusionDateField(row.getCell(INCLUSION_DATE)));
        errorFields.add(checkExpirationDateField(row.getCell(EXPIRATION_DATE)));
        errorFields.add(checkStartMaturityDateField(row.getCell(MATURITY_START_DATE)));
        errorFields.add(checkEndMaturityDateField(row.getCell(MATURITY_END_DATE)));
        errorFields.add(checkUrgentDebtAmountField(row.getCell(URGENT_DEBT_AMOUNT)));
        errorFields.add(checkOverdueDebtField(row.getCell(OVERDUE_DEBT)));
        errorFields.add(checkTermInterestAmountField(row.getCell(TERM_INTEREST_AMOUNT)));
        errorFields.add(checkOverdueInterestAmountField(row.getCell(OVERDUE_INTEREST_AMOUNT)));
        errorFields.add(checkFinesAmountField(row.getCell(FINES_AMOUNT)));
        errorFields.add(checkStateDutyField(row.getCell(STATE_DUTY)));
        errorFields.add(checkOverdueDebtAmountField(row.getCell(OVERDUE_DEBT_AMOUNT)));
        errorFields.add(checkDelayFormationDateField(row.getCell(DELAY_FORMATION_DATE)));
        errorFields.add(checkDelayNumbersDaysField(row.getCell(DELAY_NUMBERS_DAYS)));
        errorFields.add(checkLastPaymentDateField(row.getCell(LAST_PAYMENT_DATE)));
        errorFields.add(checkLastPaymentAmountField(row.getCell(LAST_PAYMENT_AMOUNT)));
        errorFields.add(checkTargetVolumeField(row.getCell(TARGET_VOLUME)));
        errorFields.add(checkInterestRateField(row.getCell(INTEREST_RATE)));
        errorFields.add(checkInnField(row.getCell(INN)));

        errorFields.removeIf(val -> val.equals(VALID_VALUE));
        return errorFields;
    }

    private static Integer checkCaIdField(Cell cell) {
        if(isFieldEmpty(cell)){
            return CA_ID;
        }
        return VALID_VALUE;
    }

    private static boolean isFieldEmpty(Cell cell) {
        return cell == null || cell.getStringCellValue().isEmpty();
    }

    private static Integer checkTbField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkClientIdField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkContractIdField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkContractNumberField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkContractIssueDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkContractEndDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkCreditTypeField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkCreditAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkBorrowerTypeField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkFioField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkDobField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkRegistrationAddressField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkActualAddressField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkRegistryPhoneNumberField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkActualPhoneNumberField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkMobilePhoneField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkOtherPhoneField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkRecoveryStageField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkInclusionDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkExpirationDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkStartMaturityDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkEndMaturityDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkUrgentDebtAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkOverdueDebtField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkTermInterestAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkOverdueInterestAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkFinesAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkStateDutyField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkOverdueDebtAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkDelayFormationDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkDelayNumbersDaysField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkLastPaymentDateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkLastPaymentAmountField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkTargetVolumeField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkInterestRateField(Cell cell) {
        return VALID_VALUE;
    }

    private static Integer checkInnField(Cell cell) {
        String value = cell.getStringCellValue();
        if (!value.matches("\\d")) {
            return INN;
        }
        return VALID_VALUE;
    }
}
